package com.ownTask.Task3.controller;

import java.util.List;

public class RBAScriptParam {
	private String paramName;
	private int paramDefaultValue;
	
	public int getParamDefaultValue() {
		return paramDefaultValue;
	}
	public void setParamDefaultValue(int paramDefaultValue) {
		this.paramDefaultValue = paramDefaultValue;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public RBAScriptParam(String paramName, int paramDefaultValue) {
		super();
		this.paramName = paramName;
		this.paramDefaultValue = paramDefaultValue;
	}
	
	public String getParamsAsString(List<RBAScriptParam> params) {
		StringBuilder paramAsString = new StringBuilder();
		params.stream().map(p -> getParam(p, paramAsString));
		System.out.println("final string " + paramAsString);
		return paramAsString.toString();
	}

	private StringBuilder getParam(RBAScriptParam p, StringBuilder finalString) {
		return finalString.append(p.getParamName()).append(":").append(p.getParamDefaultValue()).append(";");
	}
}
