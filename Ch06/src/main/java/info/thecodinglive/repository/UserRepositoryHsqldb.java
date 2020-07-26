package info.thecodinglive.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.UserVO;

@Repository
public class UserRepositoryHsqldb {
	private static final String MAPPER_NAME_SPACE="sample.mapper.userMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List getuserInfoAll() {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
	}
	
	public void addUserInfo(UserVO userVO) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "addUserInfo", userVO);
	}
	
	public List findByUserNameLike(String userName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserNameLike", params);
	}
	
	public UserVO findByUserName(String userName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "findByUserName", params);
	}
	
	public List<HashMap<String, Object>> findByForeach(Map<String, Object> paraMap) {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserName", paraMap);
	}
}
