class Animal{
	void makeSound() {
		System.out.println("Animal makes sound");
	}
}
public class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Dog Barks");
	}
	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.makeSound();
	}

}
