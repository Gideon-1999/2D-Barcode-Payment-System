
package sjsu.mobilepayment.client;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
//import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import sjsu.mobilepayment.client.R;
//import sjsu.mobilepayment.client.R.drawable;


class WalletAdapterView extends LinearLayout {        
	public WalletAdapterView(Context context, WalletItem device) 
	{
		super( context );		
		/*setOnClickListener((OnClickListener) context);
		setClickable(true);
		setFocusable(false);*/
		setId(device.getDeviceID());
		    
		//container is a horizontal layer
		setOrientation(LinearLayout.HORIZONTAL);
		setPadding(0, 6, 0, 6);
		
		//image:params
		LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		Params.setMargins(6, 0, 6, 0);
		//image:itself
//		ImageView ivLogo = new ImageView(context);
//		// load image
//		
//			ivLogo.setImageDrawable(context.getResources().getDrawable(R.drawable));
//		//image:add
//		addView(ivLogo, Params);
		
		//vertical layer for text
		Params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		LinearLayout PanelV = new LinearLayout(context);
		PanelV.setOrientation(LinearLayout.VERTICAL);
		PanelV.setGravity(Gravity.BOTTOM);
		
		TextView textName = new TextView( context );
		textName.setTextSize(16);
		textName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		textName.setText( "Credit: "+device.getCredit()+"  Debit: "+device.getDebit());
		PanelV.addView(textName);       
		
		TextView textAddress = new TextView( context );
		textAddress.setTextSize(16);
		textAddress.setText( "Date: "+device.getDate());
		PanelV.addView(textAddress);    
		
		addView(PanelV, Params);
	}
}


public class WalletAdapter extends BaseAdapter /*implements OnClickListener*/ {
	
	/*private class OnItemClickListener implements OnClickListener{           
	    private int mPosition;
	    OnItemClickListener(int position){
	            mPosition = position;
	    }
	    public void onClick(View arg0) {
	            Log.v("ddd", "onItemClick at position" + mPosition);                      
	    }               
	}*/

	public static final String LOG_TAG = "BI::CA";
    private Context context;
    private List<WalletItem> deviceList;

    public WalletAdapter(Context context, List<WalletItem> deviceList ) { 
        this.context = context;
        this.deviceList = deviceList;
    }

    public int getCount() {                        
        return deviceList.size();
    }

    public Object getItem(int position) {     
        return deviceList.get(position);
    }

    public long getItemId(int position) {  
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) 
    { 
        WalletItem device = deviceList.get(position);
        View v = new WalletAdapterView(this.context, device );
        
        v.setBackgroundColor(Color.BLACK);
        
        /*v.setOnClickListener(new OnItemClickListener(position));*/
        return v;
    }

    /*public void onClick(View v) {
            Log.v(LOG_TAG, "Row button clicked");
    }*/

}


