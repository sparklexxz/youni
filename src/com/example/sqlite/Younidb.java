package com.example.sqlite;

import java.util.ArrayList;
import java.util.List;

import model.Search_need;
import model.Search_out;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Younidb {
	public static final String DB_NAME="youni";//���ݿ�����
	private static final int VERSION=1;//���ݿ�汾
	private static  Younidb younidb;
	private SQLiteDatabase db;
	//�����췽��˽�л�
	private Younidb(Context context){
		search_DatabaseHelper dbHelper=new search_DatabaseHelper(context,DB_NAME,null,VERSION);
		db=dbHelper.getWritableDatabase();
	}
	//��ȡYounidb��ʵ��
	public synchronized static Younidb getInstance(Context context){
		if(younidb == null){
			younidb=new Younidb(context);
		}
		return younidb;
	}
	public void saveSearch_out(Search_out search_out){
		if(search_out!=null){
			ContentValues values=new ContentValues();
			values.put("name", search_out.getName());
			values.put("detailed", search_out.getDetailed());
			values.put("like", search_out.getLike());
			values.put("history", search_out.getHistory());
			values.put("time", search_out.getTime());
		}
	}
	//�����ݿ��ȡ��������ϸ��Ϣ��
	public List<Search_out> loadSearch_out(){
		List<Search_out> list =new ArrayList<Search_out>();
		Cursor cursor=db.query("Search_out", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Search_out search_out=new Search_out();
				search_out.setId(cursor.getInt(cursor.getColumnIndex("id")));
				search_out.setName(cursor.getString(cursor.getColumnIndex("name")));
				search_out.setDetailed(cursor.getString(cursor.getColumnIndex("detailed")));
				search_out.setLike(cursor.getString(cursor.getColumnIndex("like")));
				search_out.setHistory(cursor.getString(cursor.getColumnIndex("history")));
				search_out.setTime(cursor.getString(cursor.getColumnIndex("time")));
				list.add(search_out);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	public void saveSearch_need(Search_need search_need){
		if(search_need!=null){
			ContentValues values=new ContentValues();
			values.put("name", search_need.getName());
			values.put("detailed", search_need.getDetailed());
			values.put("like", search_need.getLike());
			values.put("history", search_need.getHistory());
			values.put("time", search_need.getTime());
		}
	}
	//�����ݿ��ȡ��������ϸ��Ϣ��
	public List<Search_need> loadSearch_need(){
		List<Search_need> list =new ArrayList<Search_need>();
		Cursor cursor=db.query("Search_need", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Search_need search_need=new Search_need();
				search_need.setId(cursor.getInt(cursor.getColumnIndex("id")));
				search_need.setName(cursor.getString(cursor.getColumnIndex("name")));
				search_need.setDetailed(cursor.getString(cursor.getColumnIndex("detailed")));
				search_need.setLike(cursor.getString(cursor.getColumnIndex("like")));
				search_need.setHistory(cursor.getString(cursor.getColumnIndex("history")));
				search_need.setTime(cursor.getString(cursor.getColumnIndex("time")));
				list.add(search_need);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	
	


}
