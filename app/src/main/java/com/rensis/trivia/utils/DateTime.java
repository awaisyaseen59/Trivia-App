package com.rensis.trivia.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {


    public static final String DateFormat = "MMM dd, yyyy";
    public static final String TimeFormat = "hh:mm a";
    public static final String DateTimeFormat = "MMM dd, yyyy - hh:mm a";
    public static final String DateTimeFormatWOss = "dd/MM/yyyy HH:mm";
    public static final String DateFormatWithDayName = "EEEE, dd MMM, yyyy";
    public static final String SimpleDateFormat = "dd/MM/yyyy";
    public static final String MonthYear = "MM/yy";
    public static final String SimpleDateFormatDash = "dd-MM-yyyy";
    public static final String ServerDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String DotNetTimeFormat = "dddd, MMMM dd, yyyy h:mm:ss a";

    public static String format(Date STAMP, String FORMAT) {
        java.text.SimpleDateFormat from = new SimpleDateFormat(FORMAT);
        String formattedDate = null;
        try {
            formattedDate = from.format(STAMP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static Date format(String dateTime, String foramt) {
        java.text.SimpleDateFormat from = new SimpleDateFormat(foramt);
        Date formattedDate = null;
        try {
            formattedDate = from.parse(dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }


    public static String formatServerDateTime(String timeDate) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        try {
            Date date = sdf.parse(timeDate);
            System.out.println(date);
            String your_format = new SimpleDateFormat(DateTimeFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            //Logger.log(Logger.EXCEPTION, e);
            return timeDate;
        }
    }

    public static String formatServerDateTime(String dateTime, String format) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        try {
            Date date = sdf.parse(dateTime);
            System.out.println(date);
            String your_format = new SimpleDateFormat(format).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return dateTime;
        }
    }

    public static String formatServerTime(String serverFormat) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        try {
            Date date = sdf.parse(serverFormat);
            System.out.println(date);
            String your_format = new SimpleDateFormat(TimeFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return serverFormat;
        }
    }

    public static String formatServerDate(String value) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        try {
            Date date = sdf.parse(value);
            System.out.println(date);
            String your_format = new SimpleDateFormat(DateFormat).format(date);
            return your_format;
        } catch (ParseException e) {
            // Logger.log(Logger.EXCEPTION, e);
            return value;
        }
    }

    public static String getCurrentDateTime(String formate) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(new Date());
    }

    public static String getCurrentDateTime() {
        java.text.SimpleDateFormat from = new SimpleDateFormat(DateTimeFormat);
        String current = from.format(new Date());
        return current;
    }

    public static String getCurrentDate() {
        java.text.SimpleDateFormat from = new SimpleDateFormat(SimpleDateFormat);
        String current = from.format(new Date());
        return current;
    }

    public static String getCurrentTimeOnly() {
        Calendar calendar = Calendar.getInstance();
        java.text.SimpleDateFormat mdformat = new SimpleDateFormat(TimeFormat);
        return mdformat.format(calendar.getTime());
    }

    public static long getTimeDifference(String orderTime) {
        java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(getCurrentTimeOnly());
            date2 = simpleDateFormat.parse(orderTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference = date2.getTime() - date1.getTime();
        long days = (int) (difference / (1000 * 60 * 60 * 24));
        long hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        long minutes = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
        return (minutes - 15);
    }

    public static String convert24To12(String STAMP) {
        java.text.SimpleDateFormat from = new SimpleDateFormat("hh:mm:ss");
        java.text.SimpleDateFormat to = new SimpleDateFormat(TimeFormat);
        String formattedDate = null;
        try {
            formattedDate = to.format(from.parse(STAMP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static String getTimeStamp() {
        return System.currentTimeMillis() + "";
    }

    public static String getTimeStampForKey() {
        return (System.currentTimeMillis() / 1000) + "";
    }

    public static String getFormatedDateTime(String STAMP) {
        java.text.SimpleDateFormat from = new SimpleDateFormat(DateTimeFormat);
        java.text.SimpleDateFormat to = new SimpleDateFormat(DateFormat + " " + TimeFormat);
        String formattedDate = null;
        try {
            formattedDate = to.format(from.parse(STAMP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static boolean firstIsEqualesSecond(String date1, String date2) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(DateTime.DateFormat);
        Date first = null;
        Date second = null;
        try {
            first = sdf.parse(date1);
            second = sdf.parse(date2);
            if (first.equals(second)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


    public static void showDatePicker(Activity activity, final pickerCallback callback) {
        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {

            monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (String.valueOf(monthOfYear).length() == 1) {
                m = "0" + monthOfYear;
            }
            if (String.valueOf(dayOfMonth).length() == 1) {
                d = "0" + dayOfMonth;
            }
            if (callback != null)
                callback.onSelected(m + "-" + d + "-" + year);

        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        dialog.show();
    }

    public static void showDatePickerWithLimit(Activity activity, final pickerCallback callback, boolean maxLimit, boolean minLimit) {
        int yy;
        int mm;
        int dd;
        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {

            monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (String.valueOf(monthOfYear).length() == 1) {
                m = "0" + monthOfYear;
            }
            if (String.valueOf(dayOfMonth).length() == 1) {
                d = "0" + dayOfMonth;
            }
            if (callback != null)
                callback.onSelected(m + "-" + d + "-" + year);

        }, yy, mm, dd);
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        if (maxLimit == true) {

            dialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
        } else if (minLimit == true) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        }
        dialog.show();
    }

    public static void showMonthYearPicker(Activity activity, final pickerCallback callback) {
        int yy;
        int mm;
        int dd;

        final Calendar calendar = Calendar.getInstance();
        yy = calendar.get(Calendar.YEAR);
        mm = calendar.get(Calendar.MONTH);
        dd = calendar.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) -> {

            monthOfYear = monthOfYear + 1;
            String d = dayOfMonth + "", m = monthOfYear + "";
            if (monthOfYear + "".toString().length() == 1) {
                m = "0" + monthOfYear;
            }
            if (dayOfMonth + "".toString().length() == 1) {
                d = "0" + dayOfMonth;
            }
            if (callback != null)
                callback.onSelected(m + "/" + year);

        }, yy, mm, dd);
        int day = activity.getResources().getIdentifier("android:id/day", null, null);
        if (day != 0) {
            View dayPicker = dialog.getDatePicker().findViewById(day);
            if (dayPicker != null) {
                dayPicker.setVisibility(View.GONE);
            }
        }
        dialog.setOnCancelListener(dialog1 -> {
            dialog1.dismiss();
            if (callback != null)
                callback.onSelected("");

        });
        dialog.show();
    }

    public static void showTimePicker(Activity activity, final pickerCallback callback) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(activity, (timePicker, selectedHour, selectedMinute) -> {
            if (callback != null)
                callback.onSelected(selectedHour + ":" + selectedMinute + ":00");
        }, hour, minute, true);
        mTimePicker.setOnCancelListener(dialog -> {
            dialog.dismiss();
            if (callback != null)
                callback.onSelected("");
        });
        mTimePicker.show();
        //Yes 24 hour time
    }

    public static Calendar convertBaseTimeToCalender(String stamp) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar convertToCalender(String formatIn, String stamp) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(formatIn);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar convertBaseTimeToCalenderDefaultTimeZone(String stamp) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat(ServerDateTimeFormat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(sdf.parse(stamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static String calculateHoursMinutesFrom(Calendar start, Calendar end) {
        long difference = (end.getTimeInMillis() - start.getTimeInMillis()) / 1000;
        int hours = (int) difference / 3600;
        difference = difference % 3600;
        int minuts = (int) difference / 60;
        int seconds = (int) difference % 60;
        if (hours > 0) {
            return hours + "h " + minuts + "m " + seconds + "s";
        } else if (minuts == 0) {
            return seconds + " sec";
        } else if (minuts == 1) {
            return minuts + " min " + seconds + " sec";
        } else if (minuts > 1) {
            return minuts + " mins " + seconds + " sec";
        } else {
            return "0 min";
        }
    }

    public static String addMinutes(String format, Integer prepTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, prepTime);
        return DateTime.format(calendar.getTime(), format);
    }


    public interface pickerCallback {
        void onSelected(String arg1);
    }
}
