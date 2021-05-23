package com.cominatyou.networktoggler

import android.provider.Settings
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class QuickSettingsTile: TileService() {
    override fun onTileAdded() {
        super.onTileAdded()
        if (Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 25 || Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 27) {
            qsTile.state = Tile.STATE_ACTIVE
            qsTile.subtitle = if (Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 25) "On" else "Global"
            qsTile.updateTile()
        }
        else {
            qsTile.state = Tile.STATE_INACTIVE
            qsTile.subtitle = "LTE"
            qsTile.updateTile()
        }
    }
    override fun onStartListening() {
        super.onStartListening()
        if (Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 25 || Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 27) {
            qsTile.state = Tile.STATE_ACTIVE
            qsTile.subtitle = if (Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 25) "On" else "Global"
            qsTile.updateTile()
        }
        else {
            qsTile.state = Tile.STATE_INACTIVE
            qsTile.subtitle = "LTE"
            qsTile.updateTile()
        }
    }

    override fun onClick() {
        super.onClick()
        if (Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 25 || Settings.Global.getInt(contentResolver, "preferred_network_mode3") == 27) {
            Settings.Global.putInt(contentResolver, "preferred_network_mode3", 8)
            qsTile.state = Tile.STATE_INACTIVE
            qsTile.subtitle = "LTE"
            qsTile.updateTile()
        }
        else {
            Settings.Global.putInt(contentResolver, "preferred_network_mode3", 27)
            qsTile.state = Tile.STATE_ACTIVE
            qsTile.subtitle = "Global"
            qsTile.updateTile()
        }
    }
}