package comc.shiv.csdn;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.List;

public class HttpServerResponse extends AsyncTask<String,String,String>{
	public AsyncResponse delegate = null;
	InputStream inputStream = null;
    String result = "";	
    List<NameValuePair> nameValuePairs = null;
   
	@Override
	protected void onPostExecute(String output) {
	    // TODO Auto-generated method stub			//
	    super.onPostExecute(result);
	    Log.e("Testing", "onPostExecute result is  "+output);		      
	    // update text view here
	    delegate.postExecutePerform(output);
	}

	@Override
	protected void onPreExecute() {
	    // TODO Auto-generated method stub
	    super.onPreExecute();
	}

	@Override
	protected String doInBackground(String... params) {
	     try
	       {
			    HttpClient httpClient = new DefaultHttpClient();
	    	 	Log.e("Testing", "the url parameter is "+params[0]);
				HttpPost httpPost = new HttpPost(params[0]);
				if(nameValuePairs != null)
				{
					httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				}
				HttpResponse httpResponse = (HttpResponse) httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
	            if(httpEntity != null){
	            	result = EntityUtils.toString(httpEntity);
	            	Log.e("Testing", "The HTTP Reponse is  "+result);		            	
	            }
	            else
	            {			            	
	            	result =  "No string.";
	            }
	       }
	      catch(Exception e)
	     	{
	     		Log.d("InputStream", e.getLocalizedMessage());
				result = "No string.";
		    }		     
	     return result;
	}
}
