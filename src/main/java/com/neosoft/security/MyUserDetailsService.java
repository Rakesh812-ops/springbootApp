package com.neosoft.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.commons.Constant;
import com.neosoft.entity.User;
import com.neosoft.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepo.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException(Constant.USER_NOT_FOUND);
		}
		return new UserPrincipal(user);
	}
		
	/*@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			List<SimpleGrantedAuthority> roles= null;
			
			if(username.equals("Admin")) {
				roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
				return new User("Admin","eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTYwNjI4MDQxMSwiaWF0IjoxNjA2MjgwNDExfQ.rF6YaT43JB6dSb9NRv_Tispyvcb1FMGZ_CZmG9OIbQ8",new roles);
			}
			
			if(username.equals("User")) {
				roles=Arrays.asList(new SimpleGrantedAuthority("USER"));
				return new User("User","eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTYwNjI4MDQxMSwiaWF0IjoxNjA2MjgwNDExfQ.mLBaBjr018RDAhC4Wl-nS-DcTyj_Kir38usT1L-WbvQ",roles);
			}
			throw new UsernameNotFoundException(Constant.USER_NOT_FOUND);
		}*/

	}


