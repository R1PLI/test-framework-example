import api.IPost;
import org.aeonbits.owner.ConfigFactory;

public class Main {
	public static void main(String[] args) {
		IPost prod = ConfigFactory.create(IPost.class);
		System.out.println(prod.id());
		System.out.println(prod.title());
		System.out.println(prod.author());
	}
}
