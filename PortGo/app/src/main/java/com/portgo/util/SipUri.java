/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.portgo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SipUri {
	int mPort;
	String mUserName;
	String mPassWd;
	String mDisplayName;
	String mScheme;
	String mHost;
	boolean mValid;
	String mUri;
	boolean bParse = false;
	public SipUri(String uriString, String displayName) {
		setDisplayName(displayName);
		mUri=uriString;
		parse();				
	}
		
  public void parse() {
	  if(bParse==false){
		  parseUriString(mUri);
		  bParse = true;
	  }
  }
  public boolean isValid() {	  
	  return mValid;
  }

  public String getScheme() {
	  return mScheme;
  }

  public String getUserName() {
	  return mUserName;
  }

  public String getDisplayName() {
	  return mDisplayName;
  }

  public void setDisplayName(String displayName) {
	  mDisplayName = displayName;
  }
  
  public void setValid(boolean isvalid){
	  mValid = isvalid;
  }
  
  public void setScheme(String scheme) {
	  mScheme = scheme;
  }

  public void setUserName(String userName) {
	  mUserName = userName;
  }

  public void parseUriString(String uri){
	  		
		if(uri==null){
			  setValid(false);
			  return; 
		}
	  
	  Pattern pattern = Pattern.compile("^(sip:|sips:|tel:)");
	  Matcher matcher = pattern.matcher(uri);
	  
	  if(matcher.find()){
		  setScheme(uri.substring(matcher.start(), matcher.end()));
		  String[] subStrings = uri.substring(matcher.end()).split("@");
		  if(subStrings.length>0){
			  setUserName(subStrings[0]);
			  if(mDisplayName==null||mDisplayName.length()<1)
				  setDisplayName(subStrings[0]);
		  }
		  setValid(true);
	  }
  }
}