package com.ecloudtime.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class DateUtil {

	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	
	private final static SimpleDateFormat sdfYearMonthDay = new SimpleDateFormat("yyyy年MM月dd日");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat sdfTimeZone = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private final static SimpleDateFormat sdfTimeNow = new SimpleDateFormat(
			"HHmmss");
	
	public static final String longTimeStr="yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}
	
	public static String getTimes(){
		return sdfTimeNow.format(new Date());
	}
	
	

	public static String getDaysyyyyMMddHHmmss(){
		return sdfTimeZone.format(new Date());
	}
	
	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}
	
	public static String getTime(Date date) {
		return sdfTime.format(date);
	}
	
	public static String getTime(Date date,String formatDate) {
		 SimpleDateFormat sdfTime = new SimpleDateFormat(formatDate);
		return sdfTime.format(date);
	}

	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e   yyyy-MM-dd
	* @return boolean  
	* @throws
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() <=fomatDate(e).getTime();
	}
	
	/**
	 * if(s>= w >= e)true
	 * else false
	 * @param s
	 * @param w
	 * @param e
	 * compareDate("2016-04-31","2016-05-31","2016-06-31") return true;
	 * compareDate("2016-04-31","2016-04-31","2016-06-31") return true;
	 * compareDate("2016-04-31","2016-06-31","2016-06-31") return true;
	 * compareDate("2016-04-31","2016-03-31","2016-06-31") return false;
	 * compareDate("2016-04-31","2016-07-31","2016-06-31") return false;
	 * compareDate("2016-06-31","2016-05-31","2016-04-31") return false;
	 * compareDate("2016-06-31","2016-07-31","2016-04-31") return false;
	 * compareDate("2016-06-31","2016-03-31","2016-04-31") return false;
	 * @return
	 */
	public static boolean compareDate(String s, String w, String e) {
		if(compareDate(s, e) && compareDate(s, w) && compareDate(w, e)){
			return true;	
		}else{
			return false;
		}
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * @param s
	 * @param e
	 * @return
	 */
	public static boolean compareLongDate(String s, String e) {
		if(fomatLongDate(s)==null||fomatLongDate(e)==null){
			return false;
		}
		return fomatLongDate(s).getTime() <=fomatLongDate(e).getTime();
	}
	
	public static boolean compareThreeeDate(String start, String end){
		String mid=getDay();
		return compareDate(start,mid)&&compareDate(mid,end)&&compareDate(start,end);
	}
	
	public static boolean compareThreeeLongDate(String start, String end){
		String mid=getTime();
		return compareLongDate(start,mid)&&compareLongDate(mid,end)&&compareLongDate(start,end);
	}
	//计算几分钟前
	public static String getBeforeTime(Date nowDate,String BeforeDate){
		Date BfDate = DateUtil.fomatLongDate(BeforeDate);
		int time  =(int)((nowDate.getTime()-BfDate.getTime())/(60*60*1000));
		if(time < 24){
			if(time<1){
				int min =(int)((nowDate.getTime()-BfDate.getTime())/(60*1000));
				if(min < 1){
						int sec  = (int)((nowDate.getTime()-BfDate.getTime())/(1000));
						if(sec <1){
							sec = 1;
						}
						return (String.valueOf(sec)+"秒前");
				}else{
					return (String.valueOf(min)+"分钟前");
				}
			}else{
				return (String.valueOf(time)+"小时前");
			}
		}else{
			return BeforeDate.substring(5, 10);
		}
		
	}
	/**
	 * 日期减法得到小时数
	 * @param s
	 * @param e
	 * @return
	 */
	public static Integer dateSubtraction(String s, String e) {
		return (int) ((fomatLongDate(e).getTime()-fomatLongDate(s).getTime())/(60 * 60 * 1000));
	}
	
	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date,String format) {
		DateFormat fmt = new SimpleDateFormat(format);
		try {
			try {
				return fmt.parse(date);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static Date fomatDate(String date){
		return fomatDate(date,"yyyy-MM-dd");
	}
	
	public  static Date fomatLongDate(String date){
		return fomatDate(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	//2016-05-18 12:01:53

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static boolean isValidLongDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				try {
					beginDate = format.parse(beginDateStr);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					endDate= format.parse(endDateStr);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    public static long getHourSub(String beginDateStr){
    	return getHourSub(beginDateStr,getTime());
    }
    
    public static long getHourSub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				try {
					beginDate = format.parse(beginDateStr);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					endDate= format.parse(endDateStr);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
   /* gc.add(1,-1)表示年份减一.
    *gc.add(2,-1)表示半年 减一.？？？？有问题 2是月份减一 并没有半年减一 (×)
    *gc.add(2,-1)表示月份 减一. (√)
    *gc.add(3.-1)表示周减一.
    *gc.add(4.-1)表示周 减一.
    *gc.add(5,-1)表示天减一.*/
    public static Date getOperDate(Date date,int oper){
    	GregorianCalendar gc=new GregorianCalendar();
    	gc.setTime(date);
    	gc.add(5,oper); 
    	   return gc.getTime();
    	
    }
    
    //yyyy-MM-dd 格式时间加一天
    public static String getOperDateStr(String str,int oper){
    	Date date = fomatDate(str);
    	GregorianCalendar gc=new GregorianCalendar();
    	gc.setTime(date);
    	gc.add(5,oper); 
    	return getTime(gc.getTime(),"yyyy-MM-dd");
    }
    
    //yyyy-MM-dd 格式时间加一个月或减一个月
    public static String getOperMouthStr(String str,int oper){
    	Date date = fomatDate(str,"yyyy-MM");
    	GregorianCalendar gc=new GregorianCalendar();
    	gc.setTime(date);
    	gc.add(2,oper); 
    	return getTime(gc.getTime(),"yyyy-MM");
    }
    
    /**
     * 使YYYY-MM日期格式的字符串的日期加一个月
     */
    public static String monthOper(String monthStr){
    	String result = "";
    	String month = monthStr.substring(5, 7);
		int monthInt = Integer.parseInt(month);
		if(monthInt == 12){
			result = (Integer.parseInt(monthStr.substring(0, 4)) + 1) + "-01";
		}else{
			if((monthInt + 1) >= 10){
				result = monthStr.substring(0, 4) + "-" + (monthInt + 1);
			}else{
				result = monthStr.substring(0, 4) + "-0" + (monthInt + 1);
			}
		}
		return result;
    }
    
    /**
     * 使YYYY日期格式的字符串的日期加一年
     */
    public static String yearOper(String yearStr){
    	String result = (Integer.parseInt(yearStr) + 1) + "";
		return result;
    }
    
    /**
     * 由一个月中的任意一天的YYYY-MM-dd格式日期得到这个月的最后一天
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(String date){  
    	// 获取Calendar  
    	Calendar calendar = Calendar.getInstance();  
    	// 设置时间,当前时间不用设置  
    	calendar.setTime(fomatDate(date));  
    	// 设置日期为本月最大日期  
    	calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
    	// 返回日期并且格式化
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
    	return format.format(calendar.getTime()); 
	}  
    
    public static String getOperDateStr(String dateStr,int operFreq,int openDetail){
    	Date date = fomatLongDate(dateStr);
    	GregorianCalendar gc=new GregorianCalendar();
    	gc.setTime(date);
    	gc.add(operFreq, openDetail);
    	return getTime(gc.getTime());
    } 
    
    public static Date getOperDate(String datestr,int oper){
    	return getOperDate(fomatLongDate(datestr),oper);
    	
    }
    
    
    public static String getWeekDay(Date dt){
    	  Calendar cal = Calendar.getInstance();
          cal.setTime(dt);
          int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	return ""+w;
    }
    public static String getWeekDayChn(Date dt){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dt);
    	int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	String weekStr="星期";
    	if(1==w){
    		weekStr+="一";
    	}else if(2==w){
    		weekStr+="二";
    	}else if(3==w){
    		weekStr+="三";
    	}else if(4==w){
    		weekStr+="四";
    	}else if(5==w){
    		weekStr+="五";
    	}else if(6==w){
    		weekStr+="六";
    	}else if(0==w){
    		weekStr+="日";
    	}
    	return weekStr;
    }
    
    public static String getWeekBegin(){
    	  Calendar cal =Calendar.getInstance();
    	  cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	//  System.out.println(cal.getTime());
    	  String time = getTime(cal.getTime(),"yyyy-MM-dd");
//    	  System.out.println(time);
    	  return time;
    	 }
    
    public static String getWeekEnd(){
  	  Calendar cal =Calendar.getInstance();
  	  cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
  	cal.add(Calendar.DAY_OF_WEEK, 7);
  	//  System.out.println(cal.getTime());
  	  String time = getTime(cal.getTime(),"yyyy-MM-dd");
//  	  System.out.println(time);
  	  return time;
  	 }
    
    
    public static String getMonthDay(Date dt){
  	  Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int monthDay = cal.get(Calendar.DAY_OF_MONTH) ;
  	return ""+monthDay;
  }
    
    public static String getMonthBegin(){
    	  Calendar cal =Calendar.getInstance();
    	  cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 01);
    	  return getTime(cal.getTime(),"yyyy-MM-dd");
    }
    
    public static String getMonthEnd(){
    	  Calendar cal =Calendar.getInstance();
    	  int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    	  cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay);
    	  return getTime(cal.getTime(),"yyyy-MM-dd");
  }
    
    
	public static String getYearBegin() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		return getTime(cal.getTime(), "yyyy-MM-dd");
	}

	public static String getYearEnd() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 11); 
        cal.set(Calendar.DATE, 31); 
		return getTime(cal.getTime(), "yyyy-MM-dd");
	}
    
    
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    public static String getAfterMonthDate(String months) {
        return getAfterDayDate(getMonthDays(Integer.valueOf(months)));
    }
    
    public static String getMonthDays(int months){
    	int currentMoth=getCurrentMonth();
    	int monthEnd=currentMoth+months;
    	int alldays=0;
    		for(int i=currentMoth;i<monthEnd;i++){
    			alldays+=getMonthDay(i);
    		}
    	return ""+alldays;
    }
    
    
    public static int  getMonthDay(int month){
    	
    	if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
    		return 31;
    	if(month==4||month==6||month==9||month==11)
    		return 30;
    	if(month==2){
    		 Calendar cal = Calendar.getInstance(Locale.CHINA);
    		 int year = cal.get(Calendar.YEAR);
    		 if(leapYear(year)){
    			 return 29;
    		 }
    		 return 28;
    	}
		return month;
    }
    
    public static boolean leapYear(int year)
	{
		if(((year%100==0)&&(year%400==0))||((year%100!=0)&&(year%4==0)))
			return  true;
		
		return false;
	}
    
    public static int getCurrentMonth(){
    	Calendar cal = Calendar.getInstance(Locale.CHINA);
    	 int month = cal.get(Calendar.MONTH) + 1;
    	 return month;
    }
    
    public static int getDayOfMonth(){
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		int allday=cal.getActualMaximum(Calendar.DATE);
		int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	    int dow = cal.get(Calendar.DAY_OF_WEEK);
	    int dom = cal.get(Calendar.DAY_OF_MONTH);
	    int doy = cal.get(Calendar.DAY_OF_YEAR);
		return day;
	}
    
    
    public static String getShowFrontDay(){
    	Date nowDate = new Date();
    	return sdfYearMonthDay.format(nowDate)+" "+getWeekDayChn(nowDate);
    }
//    
//    Calendar cal = Calendar.getInstance();
//    cal.setTime(date);
//    return cal.get(Calendar.DAY_OF_WEEK);
    
    
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }
    

	public static String getDateFromUnixTime(long unixTime){
//		unixTime=System.currentTimeMillis();
//		System.out.println(new java.text.SimpleDateFormat(longTimeStr).format(new java.util.Date (unixTime)));
//		String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(unixTime*1000));
//		System.out.println("data:"+date);
		return new java.text.SimpleDateFormat(longTimeStr).format(new java.util.Date (unixTime*1000));
	}
	
	public static long getUnixTime(){
		//new Date().getTime()/1000
		return System.currentTimeMillis()/1000;
	}
	
	public static void main(String[] args) {
//    	System.out.println(getDays());
//    	System.out.println(getDaysyyyyMMddHHmmss());
//    	System.out.println(getDays());
//    	System.out.println(getTimes());
//    	System.out.println(getAfterMonthDate("10"));
    	
    	System.out.println(compareDate("2016-06-31","2016-07-31","2016-04-31"));//false
    	System.out.println(compareDate("2016-04-31","2016-05-31","2016-06-31"));//true
    	System.out.println(compareDate("2016-06-31","2016-05-31"));//false
//    	System.out.println(compareThreeeDate("2016-05-25","2016-05-24"));
////    	System.out.println(getAfterDayDate("2016-05-25"));
//    	System.out.println(getOperDate(getDay()+" 00:00:00",-1));
//    	System.out.println(getLastDate());
//    	System.out.println(fomatLongDate("2016-05-18 12:01:53"));
//    	System.out.println(fomatLongDate("2016-05-18 12:01:53"));
    	System.out.println(getOperDateStr("2016-03-01",-1));
//    	Date nowDate=new Date();
//    	Date comparDate=DateUtil.getOperDate("2016-05-16 12:01:53",1);
//		int compareless=comparDate.compareTo(nowDate);
//		System.out.println("nowDate="+nowDate+" comparDate="+comparDate+" compareless="+compareless);
//    	System.out.println(getAfterDayWeek("3"));
/*    	
    	Calendar c = Calendar.getInstance();
    	  // 这是已知的日期
    	  Date d = new Date();
    	  c.setTime(d);
    	 
    	  c.set(Calendar.DAY_OF_MONTH, 1);
    	  // 1号的日期
    	  d = c.getTime();
    	  System.out.println(Tools.date2Str(d));
    	  
    	  System.out.println(getWeekDay(new Date()));
    	  System.out.println(getMonthDay(new Date()));
//    	  System.out.println(getWeekBegin());
//    	  System.out.println(getWeekEnd());
    	  System.out.println(getMonthBegin());
    	  System.out.println(getMonthEnd());
    	  System.out.println(getYearBegin());
    	  System.out.println(getYearEnd());
    	  System.out.println(getOperDate("2016-08-01 00:00:00",-1));
    	  System.out.println(getTime(new Date(),"YYYY-MM-dd"));*/
    	  System.out.println(getWeekDay(new Date()));
    	  System.out.println(getWeekDayChn(new Date()));
    	  System.out.println(getShowFrontDay());
    	  System.out.println(getHourSub("2016-08-11 09:00:00"));
    	  System.out.println(dateSubtraction("2016-08-17 14:30:00","2016-08-17 16:00:00"));
    	  System.out.println(isValidLongDate("2016-08-17 14:30:00"));
    	  System.out.println(getOperDateStr("2016-08-17 14:30:00",Calendar.HOUR,2));
    	  System.out.println("23.98".substring(0, "23.98".indexOf('.')));
    	  System.out.println(getDay().substring(0, 7));
    	  System.out.println(getOperMouthStr("2016-01",-1));
    	  System.out.println(getLastDayOfMonth("2016-04-29"));
		
		DateUtil dateUtil = new DateUtil();
		;
		System.out.println(dateUtil.getDateFromUnixTime(1486697869));
		System.out.println(dateUtil.getDateFromUnixTime(getUnixTime()));
		System.out.println(dateUtil.getDateFromUnixTime(new Date().getTime()/1000));
		
	}
}
