package com.fine.distribution.common;

/**
 * @author Mickey
 * 
 *         2015年2月5日下午2:51:40
 */
public class ConstantsDB {

	// 数据库变量
	public static final int DB_SEX_MAN = 0;// 性别 男
	public static final int DB_SEX_WOMAN = 1;// 性别 女

	public static final int DB_IS_CANCEL_FALSE = 0;// 预约是否取消 否
	public static final int DB_IS_CANCEL_TRUE = 1;// 预约是否取消 是

	public static final int DB_IS_Appointment_FALSE = 0;// '是否履约0没有，1履约',
	public static final int DB_IS_Appointment_TRUE = 1;// '是否履约0没有，1履约',

	public static final int DB_IS_DEL_FALSE = 0;// '没有删除',
	public static final int DB_IS_DEL_TRUE = 1;// '已经删除',

	public static final int DB_CASE_DETAIL_TYPE_REPORT_IMAGE = 1;// 报告照片
	public static final int DB_CASE_DETAIL_TYPE_REPORT = 2;// 检查报告
	public static final int DB_CASE_DETAIL_TYPE_RISREPORT = 3;// 2 检验报告
	public static final int DB_CASE_DETAIL_TYPE_CASE = 4;// 3 病例
	public static final int DB_CASE_DETAIL_TYPE_DRUG = 5;// 4 用药记录
	public static final int DB_CASE_DETAIL_TYPE_ALLERGY = 6;// 5 过敏史;
}
