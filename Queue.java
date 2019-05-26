class Vehicle{
	private String vehicleId;
	public Vehicle(String vehicleId){
		this.vehicleId=vehicleId;
	}
	public void park(int location){
		System.out.println("Vehicle parking");
	}
	public String getVehicleId(){
		return vehicleId;
	}
	public void  setVehicleId(String vehicleId){
		this.vehicleId=vehicleId;
	}
}
class Car extends Vehicle{
	
	Car(String vehicleId){
		super(vehicleId);
	}
	public void park(int location){
		System.out.println("Car Parking.. "+getVehicleId()+" : "+location);
	}	
}
class Van extends Vehicle{
	Van(String vehicleId){
		super(vehicleId);
	}
	public void park(int location){
		System.out.println("Van Parking.. "+getVehicleId()+" : "+location);
	}
}
class Bus extends Vehicle{
	Bus(String vehicleId){
		super(vehicleId);
	}
	public void park(int location){
		System.out.println("Bus Parking.. "+getVehicleId()+" : "+location);
	}
} 

class VehicleQueue{
	Node front;
	public void enQueue(Vehicle vehicle){
		Node node=new Node(vehicle);
		if(front==null){
			front=node;
		}else{
			Node temp=front;
			while(temp.next!=null){
				temp=temp.next;
			}	
			temp.next=node;
		}
	}
	public void deQueue(){
		if(front!=null){
			front=front.next;
		}
	}
	public void printVehicleQueue(){
		System.out.print("[");
		Node temp=front;
		while(temp!=null){
			System.out.print(temp.vehicle.getVehicleId()+", ");
			temp=temp.next;
		}
		System.out.println("\b\b]");
	}
	public void callPark(int startingLocation){
		Node temp=front;
		while(temp!=null){
			temp.vehicle.park(startingLocation++);
			temp=temp.next;
		}			
	}
	class Node{
		private Vehicle vehicle;
		private Node next;
		Node(Vehicle vehicle){this.vehicle=vehicle;}
	}
}
class Queue{
	public static void main(String args[]){
		VehicleQueue queue=new VehicleQueue();
		queue.enQueue(new Car("C001"));
		queue.enQueue(new Bus("B001"));
		queue.enQueue(new Bus("B002"));
		queue.enQueue(new Car("C002"));
		queue.enQueue(new Car("C003"));
		queue.enQueue(new Van("V001"));
		queue.enQueue(new Car("V002"));
		queue.enQueue(new Bus("B003"));
		queue.printVehicleQueue();
		
		queue.callPark(1111);
		queue.deQueue();
		queue.printVehicleQueue();
	}
}

