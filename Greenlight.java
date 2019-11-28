public class Greenlight {
	public boolean match(
		TrafficLamp trafficLamp
		,
		Car car
		,
		Pedestrian pedestrian
		,
		Distance distance
		,
		RightOfWay rightOfWay
	) {
		if(
			checkTrafficLampConstraint(
				trafficLamp
			)
			&&
			checkCarConstraint(
				car
			)
			&&
			checkPedestrianConstraint(
				pedestrian
			)
			&&
				checkDistanceConstraint(
				distance
			)
				&&
				checkRightOfWayConstraint(
				rightOfWay
			)
		) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkTrafficLampConstraint(TrafficLamp trafficLamp) {
		if (			trafficLamp.getExists()) {
			return true;
		}
		
		return false;
	}
	public boolean checkCarConstraint(Car car) {
		if (
		car.getSpeed() > 50
 &&
		car.getColor().equals("red")
 &&
			car.getExists()) {
			return true;
		}
		
		return false;
	}
	public boolean checkPedestrianConstraint(Pedestrian pedestrian) {
		if (
		pedestrian.getLocation().equals("at_the_junction")
 &&
			pedestrian.getExists()) {
			return true;
		}
		
		return false;
	}
	public boolean checkDistanceConstraint(Distance distance) {
		if (
		distance.getMeter() > 12
						 ){
			return true;
		}
		
		return false;
	}
	public boolean checkRightOfWayConstraint(RightOfWay rightOfWay) {
		if (
		rightOfWay.getRightofway().equals("pedestrian")
						 ){
			return true;
		}
		
		return false;
	}
}
