package com.ownTask.Task3.controller;

import java.util.ArrayList;
import java.util.List;

public class Application {
		
		public static void main(String args[]) {
			RBAScriptParam param=new RBAScriptParam("chaitanya",23);
			RBAScriptParam param2=new RBAScriptParam("jlkdjsl",12);
			
			
			List<RBAScriptParam> params=new ArrayList<>();
			params.add(param);
			params.add(param2);
			
			param.getParamsAsString(params);
			
			
		}
		
		
}
