/**
 * @包名称 com.coky.user.util
 * @文件名 IdGenerator.java
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午2:28:34
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午2:28:34
 * @修改描述 
 */

package com.coky.user.util;

import java.util.UUID;

/** 
 * 功能描述 
 * @类型名称 IdGenerator
 * @版本 1.0
 * @创建者 chenyang
 * @创建时间 2015-1-21 下午2:28:34
 * @版权所有 ©2015 CTFO
 * @修改者 chenyang
 * @修改时间 2015-1-21 下午2:28:34
 * @修改描述 
 */
public class IdGenerator {

	public static final String randomId() {
		String string = UUID.randomUUID().toString();
		return string.replaceAll("-", "");
	}
}
