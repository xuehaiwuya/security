package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.security.core.properties.SecurityProperties;
import io.jsonwebtoken.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 17:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    @Autowired
    private SecurityProperties securityProperties;
//	@Autowired
//	private AppSingUpUtils appSingUpUtils;


    @PostMapping("/register")
    public void register(User user, HttpServletRequest request) {
        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
//		appSingUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
    }

    /**
     * 直接拿到当前用户的信息
     *
     * @param user
     * @return
     */
    @GetMapping("/me")
    public Object getCurrentUser(Authentication user, HttpServletRequest request) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {

        String token = StringUtils.substringAfter(request.getHeader("Authorization"), "bearer ");
        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();
        // 拿到自定义增强的参数
        String company = (String) claims.get("company");

        System.out.println(company);

        return user;
    }


    /**
     * RequestParam(required = false)用来设置参数不是必填，默认为true必填
     * 用name可以修改url参数的名字
     * defaultValue 可以设置参数的默认值
     *
     * @param username
     * @return
     */
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> getUser(@ApiParam(value = "用户名") @RequestParam(required = false, defaultValue = "1111") String username) {
        List<User> users = new ArrayList<>();
        users.add(new User("111", "1111"));
        users.add(new User("111", "1111"));
        users.add(new User("111", "1111"));
        return users;
    }

//    /**
//     * 使用条件查询类封装多个参数
//     * @param userQueryCondition
//     * @return
//     */
//    @GetMapping("/user")
//    public List<User> getUser(UserQueryCondition userQueryCondition) {
//        List<User> users = new ArrayList<>();
//        users.add(new User("111", "1111"));
//        users.add(new User("111", "1111"));
//        users.add(new User("111", "1111"));
//        return users;
//    }


//    /**
//     * 传递分页参数
//     * /user?username=111&size=15&page=2&sort=age,desc
//     * <p>
//     * 如果需要默认参数使用PageableDefault()注解
//     *
//     * @param username
//     * @param pageable
//     * @return
//     */
//    @GetMapping("/user")
//    public List<User> getUser(@RequestParam String username,
//                              @PageableDefault(page = 2,
//                                      size = 12,
//                                      sort = "age,desc") Pageable pageable) {
//
//        System.out.println(pageable.getPageSize());
//        System.out.println(pageable.getPageNumber());
//        System.out.println(pageable.getSort());
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("111", "1111"));
//        users.add(new User("111", "1111"));
//        users.add(new User("111", "1111"));
//        return users;
//    }


    /**
     * /user/{id:\d+}正则表达式对url参数进行限制
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
//		throw new RuntimeException("user not exist");
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /**
     * @param user
     * @return
     * @Valid 校验参数约束
     */
    @PostMapping
    @ApiOperation(value = "创建用户")
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;

    }

    /**
     * 更新user
     *
     * @param user
     * @param errors
     * @return
     */
    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + " " + error.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        System.out.println(user.getPassword());


        user.setId("1");
        return user;
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
