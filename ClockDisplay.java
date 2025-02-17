
/**
 * 24 HOUR INTERNAL BRANCH
 * 
 * The ClockDisplay class implements a digital clock display for a
 * US-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00am (midnight) to 11:59pm (one minute before 
 * midnight).
 * 
 * The clock represents hours in the range from 0..23, and converts to
 * range 12..1 as shown on US clocks.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Emily Lubonty
 * @version 02-10-2025
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
    int currentHour;
      
    currentHour = hours.getValue(); 
    
    if (currentHour > 11) {
        
        currentHour = currentHour - 12;
        displayString = currentHour + ":" +
                        minutes.getDisplayValue() + "PM"; 
    }
    if (currentHour <= 11) {
        
        displayString = currentHour + ":" +
                        minutes.getDisplayValue() + "AM";
    }
    if (currentHour == 0) {
        currentHour = 12; 
        displayString = currentHour + ":" +
                        minutes.getDisplayValue() + "AM";
    }
    else {
        displayString = currentHour + ":" +
                        minutes.getDisplayValue() + "PM";
    }

    }

}
