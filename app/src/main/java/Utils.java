import android.app.Activity;
import android.content.Intent;

import com.example.a332.R;

public class Utils {

    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_GREEN = 2;
    public final static int THEME_BLUE = 3;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;
        }
    }
}
