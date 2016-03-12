package Query.Query;

import java.util.Date;

public class Value
{
    public static final int INT_TYPE = 0;
    public static final int LONG_TYPE = 1;
    public static final int STRING_TYPE = 2;
    public static final int CHAR_TYPE = 3;
    public static final int BOOLEAN_TYPE = 4;
    public static final int FLOAT_TYPE = 5;
    public static final int DOUBLE_TYPE = 5;
    public static final int ARRAY_TYPE = 6;
    public static final int DATE_TYPE = 7;
    public static final int TIME_TYPE = 8;
    public static final int DATETIME_TYPE = 9;

    private final int _type;

    private int _valueInt;
    private Long _valueLong;
    private String _valueString;
    private char _valueChar;
    private boolean _valueBoolean;
    private float _valueFloat;
    private double _valueDouble;
    private String[] _valueArray;
    private Date _valueDate;
    private Date _valueTime;
    private Date _valueDateTime;

    public Value(int value)
    {
        this._valueInt = value;
        this._type = INT_TYPE;
    }

    public Value(Long value)
    {
        this._valueLong = value;
        this._type = LONG_TYPE;
    }

    public Value(String value)
    {
        this._valueString = value;
        this._type = STRING_TYPE;
    }

    public Value(char value)
    {
        this._valueChar = value;
        this._type = CHAR_TYPE;
    }

    public Value(boolean value)
    {
        this._valueBoolean = value;
        this._type = BOOLEAN_TYPE;
    }

    public Value(float value)
    {
        this._valueFloat = value;
        this._type = FLOAT_TYPE;
    }

    public Value(double value)
    {
        this._valueDouble = value;
        this._type = DOUBLE_TYPE;
    }

    public Value(String[] value)
    {
        this._valueArray = value;
        this._type = ARRAY_TYPE;
    }

    public Value(Date value)
    {
        this._valueDate = value;
        this._type = DATE_TYPE;
    }

    public int getType()
    {
        return this._type;
    }

    public String getString()
    {
        return this._valueString;
    }

    public int getInt()
    {
        return this._valueInt;
    }

    public Long getLong()
    {
        return this._valueLong;
    }

}
