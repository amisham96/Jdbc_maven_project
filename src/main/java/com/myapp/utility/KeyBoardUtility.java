package com.myapp.utility;

import com.myapp.exception.utilityexception.IntegerNotFoundExceeption;
import com.myapp.exception.utilityexception.StringNotFoundException;

public interface KeyBoardUtility {

	int getInt() throws IntegerNotFoundExceeption;

	String getString() throws StringNotFoundException;
}
