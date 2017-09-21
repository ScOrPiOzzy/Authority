package com.cas.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/userService")
public class UserService {
	private static Map<String, User> userMap = new HashMap<String, User>();

	/**
	 * 增加
	 * 
	 * @param user
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void createStudent(User user) {
		System.out.println("UserService.createStudent()");
		userMap.put(user.getUserId(), user);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@DELETE
	@Path("{id}")
	public void deleteStudent(@PathParam("id") String id) {
		System.out.println("UserService.deleteStudent()");
		userMap.remove(id);
		System.err.println("删除id为" + id + "的用户");
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void updateStudent(User user) {
		System.out.println("UserService.updateStudent()");
		userMap.put(user.getUserId(), user);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User getUserById(@PathParam("id") String id) {
		System.out.println("UserService.getUserById()");
		User u = userMap.get(id);
		return u;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getAllUsers() {
		System.out.println("UserService.getAllUsers()");
		List<User> users = new ArrayList<User>();
		users.addAll(userMap.values());
		return users;
	}
}
