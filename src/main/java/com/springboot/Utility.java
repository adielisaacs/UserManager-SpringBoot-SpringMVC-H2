package com.springboot;

import java.util.ArrayList;
import java.util.List;

import com.springboot.modal.SessionUserInfo;

public class Utility {
	List<SessionUserInfo> sessionTracker = new ArrayList<SessionUserInfo>();
	
	public boolean isValid(SessionUserInfo checkuser){
		
		for(int i=0;i<sessionTracker.size();i++){
			if( (checkuser.getUser().equals(sessionTracker.get(i).getUser())) && (checkuser.getToken().equals(sessionTracker.get(i).getToken())) ){
				return false;
			}
		}
		return true;
	}
	
	public void storeSession(SessionUserInfo checkuser){
		checkuser.setValidAmount((sessionTracker.size() + 1));
		sessionTracker.add(checkuser);
	}
	public List<SessionUserInfo> getList(){
		
		return sessionTracker;
	}
	
	public int getSizeSessionList(){
		
		return sessionTracker.size();
	}
		
	
}
