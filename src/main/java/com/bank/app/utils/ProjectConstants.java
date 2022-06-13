package com.bank.app.utils;

import java.util.Locale;


public final class ProjectConstants {


	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final String PROJECT_BASE_PACKAGE = "com.bank.app";

	public static final Locale MOROCCO_LOCALE = new Locale.Builder().setLanguage("ma").setRegion("MA").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
