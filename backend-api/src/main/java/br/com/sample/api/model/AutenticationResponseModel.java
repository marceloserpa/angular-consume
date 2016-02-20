package br.com.sample.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutenticationResponseModel {

    @JsonProperty("access_token")
    private String accessToken;
    
    @JsonProperty("token_type")
    private String tokenType = "bearer";
    
    public AutenticationResponseModel(String accessToken){
    	this.accessToken = accessToken;
    }
    
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
    
  
}
