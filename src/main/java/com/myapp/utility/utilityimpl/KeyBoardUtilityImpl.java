package com.myapp.utility.utilityimpl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.myapp.exception.utilityexception.IntegerNotFoundExceeption;
import com.myapp.exception.utilityexception.StringNotFoundException;
import com.myapp.utility.KeyBoardUtility;

public class KeyBoardUtilityImpl implements KeyBoardUtility {

	static Scanner sc = new Scanner(System.in);

	@Override
	public int getInt() throws IntegerNotFoundExceeption {
		// TODO Auto-generated method stub
		int choice = 0;
		try {
			choice = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new IntegerNotFoundExceeption("You have not given correct input");
		}
		return choice;
	}

	@Override
	public String getString() throws StringNotFoundException {
		// TODO Auto-generated method stub
		String choice = sc.nextLine();
		if (choice == null) {
			throw new StringNotFoundException("You have not given correct input");
		}
		return choice;
	}

}
