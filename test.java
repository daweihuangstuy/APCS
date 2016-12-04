public class test{
	public static void main(String[] args){
		System.out.println(Stats.mean(3, 10)); //6
		System.out.println(Stats.mean(3.1232, 4.123123)); //3.6231615
		System.out.println(Stats.max(1232, 121234)); //121234
		System.out.println(Stats.max(13212.1232, 13212.12321)); //13212.12321
		System.out.println(Stats.geoMean(4, 11)); //6
		System.out.println(Stats.geoMean(124.1232, 11)); //36.950713118964295
		
		System.out.println(Stats.max(21, 11, 21)); //21
		System.out.println(Stats.max(12.1232, 11.12, 13.1212)); //13.1212
		System.out.println(Stats.geoMean(2132, 3123, 21233)); //36.950713118964295
		System.out.println(Stats.geoMean(124.1232, 11.2123, 123.3243)); //36.950713118964295
	}
}