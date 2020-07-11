package edu0425.spring.vo;

public class UserOnOff {
	// 点赞
	public static final int OPTIONS_NOTIFYPRAISE = 1;
	// 评论 2-> 10
	public static final int OPTIONS_NOTIFYCOMMENT = 1 << 1;
	// 转发 4-> 100
	public static final int OPTIONS_NOTIFYFORWARD = 1 << 2;
	// AT
	public static final int OPTIONS_NOTIFYAT = 1 << 3;
	//关注
	public static final int OPTIONS_FOLLOWING = 1 << 4;

	public static final int OPTIONS_NOTIFYALL = OPTIONS_NOTIFYPRAISE | OPTIONS_NOTIFYCOMMENT | OPTIONS_NOTIFYFORWARD
			| OPTIONS_NOTIFYAT | OPTIONS_FOLLOWING;

	private int value;

	public UserOnOff(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isOptionNotifyPraise() {
		return (value & OPTIONS_NOTIFYPRAISE) == OPTIONS_NOTIFYPRAISE;
	}
	
	public boolean isOptionNotifyComment() {
		return (value & OPTIONS_NOTIFYCOMMENT) == OPTIONS_NOTIFYCOMMENT;
	}
	
	public boolean isOptionNotifyForward() {
		return (value & OPTIONS_NOTIFYFORWARD) == OPTIONS_NOTIFYFORWARD;
	}
	
	public boolean isOptionNotifyAt() {
		return (value & OPTIONS_NOTIFYAT) == OPTIONS_NOTIFYAT;
	}
	
	public boolean isOptionNotifyFollowing() {
		return (value & OPTIONS_FOLLOWING) == OPTIONS_FOLLOWING;
	}
	

	public static void main(String[] args) {
		UserOnOff u1 = new UserOnOff(21);
		System.out.println(u1.isOptionNotifyPraise());
		System.out.println(u1.isOptionNotifyComment());
		System.out.println(u1.isOptionNotifyForward());
		System.out.println(u1.isOptionNotifyAt());
		System.out.println(u1.isOptionNotifyFollowing());
	}
}
