// ***************************************************************************
// Copyright (c) 2022, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.industriallogic.email.suggestions;

import com.industriallogic.email.domain.DomainNameService;
import com.industriallogic.email.utils.StringUtils;

public class SuggestionsUtil {

	private static int MAX_ATTEMPTS = 5;
	private final DomainNameService domainNameService;

	/**
	 * Constructor
	 * 
	 * @param domainNameService
	 *            - Domain Name Service
	 */
	public SuggestionsUtil(final DomainNameService domainNameService) {
		this.domainNameService = domainNameService;
	}

	/**
	 * Generates Email ID based on the user name and domain name.
	 * 
	 * @param token1
	 *            - User Name
	 * @param token2
	 *            - Domain Name
	 */
	public IDTokens getIdentityTokens(String token1, String token2) {
		// remove any special chars from the tokens
		token1 = StringUtils.removeSpecialCharactersIfAny(token1, new char[] { '_', '@' });
		token2 = StringUtils.removeSpecialCharactersIfAny(token2, new char[] { '_', '@' });

		// user name and domain name combination should not be a celebrity name. If it is, then strip one char at the end
		if (domainNameService.isCelebrityName(token1, token2)) {
			token1 = token1.substring(0, token1.length() - 1);
			token2 = token2.substring(0, token2.length() - 1);
		}

		int loopCounter = 1;
		do {
			loopCounter++;
			// Generate tokens that don't contain restricted words
			String generatedFirstToken = generateFirstToken(token1);
			String generatedSecondToken = generateSecondToken(token2);
			if (generatedFirstToken == null || generatedSecondToken == null)
				return null;
			else if (domainNameService.isCelebrityName(generatedFirstToken, generatedSecondToken)) {
				// user name and domain name combination should not be a celebrity name. If it is, then strip one char at the end
				token1 = generatedFirstToken.substring(0, generatedFirstToken.length() - 1);
				token2 = generatedSecondToken.substring(0, generatedSecondToken.length() - 1);
			} else
				return new IDTokens(generatedFirstToken, generatedSecondToken);
		} while (loopCounter != MAX_ATTEMPTS); // loop for max 3 times.

		return null;
	}

	/**
	 * Generate Domain Name which don't contain restricted words
	 * 
	 * @param token2
	 *            Domain Name
	 * @return Valid Domain Name
	 */
	private String generateSecondToken(String token2) {
		int loopCounter = 0;
		boolean isRestricted = false;
		do {
			isRestricted = domainNameService.isRestrictedDomainName(token2);
			String replacement = null;
			if (isRestricted) {
				replacement = token2.substring(0, token2.length() - 1);
				token2 = token2.replaceAll(token2, replacement);
				loopCounter++;
			}
		} while (isRestricted && loopCounter != 5); // up to maxAttempts

		// return null if we've looped maxAttempt times.
		if (loopCounter == 5)
			return null;
		return token2;
	}

	/**
	 * Generate restricted words free User Name
	 * 
	 * @param token1
	 *            User Name
	 * @return Valid User Name
	 */
	private String generateFirstToken(String token1) {

		int loopCounter = 0;
		boolean isRestricted = true;
		do {
			isRestricted = domainNameService.isRestrictedUserName(token1);
			String replacement = null;
			if (isRestricted) {
				replacement = token1.substring(0, token1.length() - 1);
				token1 = token1.replaceAll(token1, replacement);
				loopCounter++;
			}
		} while (isRestricted && loopCounter != MAX_ATTEMPTS);

		if (loopCounter == MAX_ATTEMPTS)
			return null;
		return token1;
	}

	// valid email address.
	public String appendTokensForGenerateId(final IDTokens id) {
		return id.token1.toLowerCase() + "@".concat(id.token2.toLowerCase()) + ".com";
	}
}
