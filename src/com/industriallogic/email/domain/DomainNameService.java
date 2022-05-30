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

package com.industriallogic.email.domain;

public interface DomainNameService {

	boolean isRestrictedDomainName(String token);

	boolean isRestrictedUserName(String token);

	boolean isCelebrityName(String token1, String token2);

}
