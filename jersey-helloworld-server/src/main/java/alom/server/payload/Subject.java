package alom.server.payload;

import java.io.Serializable;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
public class Subject implements Serializable {
	private int id;
	private String name;
}