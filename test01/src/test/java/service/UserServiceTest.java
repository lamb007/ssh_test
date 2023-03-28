package service;


import dao.UserDao;
import entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {
    private UserService userService;

    private UserDao userDao;

    @Before
    public void setup() {
        userDao = createMock(UserDao.class);
        userService = new UserService();
        userService.setUserDao(userDao);
    }

    @Test
    public void testLoginVerify() {
        String username = "zhangsan";
        String password = "11111";

        expect(userDao.verifyUsername(username)).andReturn(true);
        expect(userDao.verifyPassword(username, password)).andReturn(true);

        replay(userDao);

        boolean passLogin = userService.loginVerify(username, password);

        verify(userDao);

        assertTrue(passLogin);
    }
    @Test
    public void testLoginVerifyFailed() {
        String username = "zhangsan";
        String password = "11111";

        expect(userDao.verifyUsername(username)).andReturn(true);
        expect(userDao.verifyPassword(username, password)).andReturn(true);

        replay(userDao);

        boolean passLogin = userService.loginVerify("lisi", password);

        verify(userDao);

        assertTrue(passLogin);
    }

    @Test
    public void testUserRegister() {
        String username = "zhangsan";
        String password = "11111";

        // 创建用于匹配的 User 对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 录制 add(User user) 方法
        expect(userDao.addUser(user)).andReturn(true);
        replay(userDao);

        // 调用测试方法
        boolean result = userService.userRegister(username, password);

        // 验证 add(User user) 方法
        verify(userDao);

        // 断言测试结果
        assertTrue(result);
    }

    @Test
    public void testUserRegisterFailed() {
        String username = "zhangsan";
        String password = "11111";

        // 创建用于匹配的 User 对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 录制 add(User user) 方法
        expect(userDao.addUser(user)).andReturn(true);
        replay(userDao);

        // 调用测试方法
        boolean result = userService.userRegister("lisi", password);

        // 验证 add(User user) 方法
        verify(userDao);

        // 断言测试结果
        assertTrue(result);
    }


}
