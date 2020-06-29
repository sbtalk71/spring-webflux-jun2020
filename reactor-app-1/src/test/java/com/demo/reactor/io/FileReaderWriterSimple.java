package com.demo.reactor.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.BaseStream;

import reactor.core.publisher.Flux;

public class FileReaderWriterSimple {

	public static void main(String[] args) throws Exception {
		
		Path filePath=Paths.get("demo.txt");
		
		Path writePath=Paths.get("demo_copy.txt");
		
		//Files.lines(filePath).forEach(System.out::println);
		Flux
		.using(()->Files.lines(filePath),Flux::fromStream,BaseStream::close)
		//.subscribe(line->System.out.println(line));
		.map(line->line+"\n")
		.subscribe(line->{
			try {
				Files.write(writePath,line.getBytes(),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

}
