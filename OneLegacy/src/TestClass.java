import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.tatharo.onelegacy.spring.dto.AppleTime;
import com.tatharo.onelegacy.spring.dto.PeachTime;
import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;

public class TestClass {
	public static List<ProductBase> productList = new ArrayList<ProductBase>();
	

	public static void main(String[] args) {
		productList.add(new PeachTime("Piet"));
		
		new Timer().scheduleAtFixedRate(new TimerTask(){@Override public void run(){TestClass.removeFalse();
		System.out.println(productList.size());}}, 5000l, 10000l);
		new Timer().schedule(new TimerTask() {
			  @Override
			  public void run() {
productList.add(new AppleTime("Jan"));			  }
			}, 12*1000);
		// TODO Auto-generated method stub

	}

	public static void removeFalse() {
		for(int i = 0, y = (productList.size()-1); i<=y;y--){if(!productList.get(y).isTimedReserved()){
			productList.remove(y);
		}
		}
			
			
		}

	}


