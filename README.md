# NetworkToggler
An quick settings tile for toggling 5G on Android phones.

## Important Information
This currently *does not work.* While I am able to flip the 'Preferred Network Type' setting between 'Global' and 'LTE' in Android settings, I can't get the radio mode to acutally switch, therefore rendering the app mostly useless, unless you like randomly pressing a button that does close to nothing. If anybody does know how to do it though, feel free to implement it and open a PR.

## Setup
Disclaimer: ADB can be scary. I don't assume any reponsibility or liability for anything you screw up on your phone; this is all done at your own discretion. I've tested this on my own phone and can confirm that the information provided below does work ***for my device, a Google Pixel 5.***

Since this modifies the global settings, it requires that you give the app `android.permission.WRITE_SECURE_SETTINGS` over adb to work.
The code might also need some tweaking depending on your phone. If you have a Pixel 5, you are good to go, as that is what I wrote this for.

For all other phones, you will need to see which PREFERRED_NETOWRK_MODE value corresponds to your SIM. To do so:

1. Start up adb for your device, and run `adb settings list global | grep preferred_network_mode`

    The output should look something like:

    ```
    $ adb shell settings list global | grep preferred_network_mode
    preferred_network_mode2=27
    preferred_network_mode3=27
    preferred_network_mode27,27
    ```
2. Change your preferred network type on your device to something different.
3. Run the command in step 1 again.
4. Compare the values outputted with the previous values. The name of the setting that changed is the name that you will need to replace `preferred_network_mode3` in [QuickSettingsTile.kt](https://github.com/CominAtYou/NetworkToggler/blob/master/app/src/main/java/com/cominatyou/networktoggler/QuickSettingsTile.kt) with.

