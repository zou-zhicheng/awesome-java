package tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.entity.User;

/**
 * @author insight
 * @since 2021/5/9
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * 根据用户名查找用户 用于登录
     *
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);
}