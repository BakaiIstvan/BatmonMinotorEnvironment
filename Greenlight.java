public class Greenlight {
	public boolean match(
		TrafficLamp trafficLamp
		,
		Car car
		,
		Bycicle bycicle
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
			checkBycicleConstraint(
				bycicle
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
	public boolean checkBycicleConstraint(Bycicle bycicle) {
		if (
		bycicle.getLocation().equals("in_front_of_the_car")
 &&
			bycicle.getExists()) {
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
		rightOfWay.getRightofway().equals("bycicle")
						 ){
			return true;
		}
		
		return false;
	}
}
