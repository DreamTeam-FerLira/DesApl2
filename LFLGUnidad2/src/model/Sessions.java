package model;

public class Sessions {

	private String sessionId;
	private String sessKey;
	private String secret;
	private int expiry;
	private String data;
	
	
	
	/**
	 * 
	 */
	/*public Sessions() {
		this("","","",0,"");
	}*/


	//Generate constructor
	/**
	 * @param sessionId
	 * @param sessKey
	 * @param secret
	 * @param expiry
	 * @param data
	 */
	public Sessions(String sessionId, String sessKey, String secret, int expiry, String data) {
		super();
		this.sessionId = sessionId;
		this.sessKey = sessKey;
		this.secret = secret;
		this.expiry = expiry;
		this.data = data;
	}
	
	
	//Generate Getters and setters
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the sessKey
	 */
	public String getSessKey() {
		return sessKey;
	}

	/**
	 * @param sessKey the sessKey to set
	 */
	public void setSessKey(String sessKey) {
		this.sessKey = sessKey;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the expiry
	 */
	public int getExpiry() {
		return expiry;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	//Generate toString
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sessions [sessionId=" + sessionId + ", sessKey=" + sessKey + ", secret=" + secret + ", expiry=" + expiry
				+ ", data=" + data + "]";
	}


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
		

}//End
