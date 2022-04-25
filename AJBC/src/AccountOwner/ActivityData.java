package AccountOwner;

import java.time.LocalDateTime;

public class ActivityData {

	private ActivityName activityName;
	private Double balanceChange;
	private LocalDateTime timeStamp;
	private String info;
	
	
	public ActivityData(ActivityName activityName, Double balanceChange, LocalDateTime timeStamp, String info) {
		this.activityName = activityName;
		this.balanceChange = balanceChange;
		this.timeStamp = timeStamp;
		this.info = info;
	}


	@Override
	public String toString() {
		return "ActivityData [activityName=" + activityName + ", balanceChange=" + balanceChange + ", timeStamp="
				+ timeStamp + ", info=" + info + "]";
	}
	
	
	
	
}
