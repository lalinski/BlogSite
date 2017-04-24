package com.lalin.test.site.blog.mix.one.Dao;

import com.lalin.test.site.blog.mix.one.security.Constants;
import com.lalin.test.site.blog.mix.one.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frzhao on 2017/4/12.
 */
@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		List<com.lalin.test.site.blog.mix.one.Dao.User> list = new ArrayList<com.lalin.test.site.blog.mix.one.Dao.User>();
		list = userRepository.findByUsername(name);
		System.out.println("List: " + list);
		if(list != null && list.size() > 0) {
			System.out.println(list.get(0).toString());
	//	return list.get(0).toString();
			return list.get(0);
		}
		throw new UsernameNotFoundException("??????");
	}

}
