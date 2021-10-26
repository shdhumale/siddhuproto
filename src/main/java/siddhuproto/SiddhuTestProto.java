package siddhuproto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.tutorial.protos.AddressBook;
import com.example.tutorial.protos.Person;
import com.example.tutorial.protos.Person.PhoneNumber;
import com.example.tutorial.protos.Person.PhoneType;


public class SiddhuTestProto {

	public static void main(String[] args) {

		System.out.println("Hello world!");


		//For Tutorial proto

		//C:\Users\Siddhartha>protoc -I=C:/STS-Workspace/siddhuproto/src/main/protobuf --java_out=C:/STS-Workspace/siddhuproto/src/main/java C:/STS-Workspace/siddhuproto/src/main/protobuf/tutorial.proto
		Person.Builder builder = Person.newBuilder();
		builder.setName("siddhu");
		builder.setId(126);
		builder.setEmail("shdhumale@gmail.com");

		System.out.println("builder.toString():-"+builder.toString());

		PhoneNumber.Builder PhoneNumberBuilder = PhoneNumber.newBuilder();
		PhoneNumberBuilder.setNumber("1111111");
		PhoneNumberBuilder.setType(PhoneType.HOME);
		//builder.setPhones(0, PhoneNumberBuilder);


		PhoneNumber.Builder PhoneNumberBuilder1 = PhoneNumber.newBuilder();
		PhoneNumberBuilder1.setNumber("222222222");
		PhoneNumberBuilder1.setType(PhoneType.MOBILE);
		//builder.setPhones(1, PhoneNumberBuilder1);


		builder.addPhones(PhoneNumberBuilder).addPhones(PhoneNumberBuilder1);


		System.out.println("builder after adding PhoneNumberBuilder1.toString():-"+builder.toString());


		AddressBook.Builder AddressBookBuilder = AddressBook.newBuilder();
		//AddressBookBuilder.setPeople(1, builder);
		AddressBookBuilder.addPeople(builder);



		System.out.println("AddressBookBuilder.toString():-"+AddressBookBuilder.toString());

		AddressBook messageAddressBookBuilder = AddressBookBuilder.build();

		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Writing to the file<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
			FileOutputStream outputStream = new FileOutputStream("AddressBook_message.bin");
			messageAddressBookBuilder.writeTo(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
