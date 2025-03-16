[![](https://jitpack.io/v/alphatech-apps/RateUsDialog.svg)](https://jitpack.io/#alphatech-apps/RateUsDialog)
(https://jitpack.io/v/alphatech-apps/RateUsDialog.svg)](
How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
gradle.kts
maven
sbt
leiningen
Add it in your root settings.gradle at the end of repositories:

	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.alphatech-apps:RateUsDialog:1.0.1'
	}




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Check if the rate dialog should be shown
        if (Rate_DialogHelper.shouldShowRateDialog(this, Calendar.SUNDAY)) {
            showRateDialog();
        }
    }

    private void showRateDialog() {
        Rate_Dialog rate_dialog = new Rate_Dialog(this);
        rate_dialog.show();

        Rate_DialogHelper.saveRateDialogShown(this); // Save that the dialog was shown
    }
}
