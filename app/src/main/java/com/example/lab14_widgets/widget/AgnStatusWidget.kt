package com.example.lab14_widgets.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import com.example.lab14_widgets.MainActivity

// Widget AGN muy simple: muestra texto y un botón para ir al panel
class AgnStatusWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // Valores de ejemplo (luego los puedes conectar a datos reales)
        val activeAlerts = 0
        val lastUpdate = "—"

        provideContent {
            AgnStatusWidgetContent(
                activeAlerts = activeAlerts,
                lastUpdate = lastUpdate
            )
        }
    }
}

@Composable
private fun AgnStatusWidgetContent(
    activeAlerts: Int,
    lastUpdate: String
) {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(text = "AirGuardNet")

        Spacer(GlanceModifier.height(4.dp))

        Text(text = "Estado del aire")

        Spacer(GlanceModifier.height(4.dp))

        val statusText =
            if (activeAlerts == 0)
                "Sin alertas críticas"
            else
                "$activeAlerts alerta(s) activa(s)"

        Text(text = statusText)

        Spacer(GlanceModifier.height(4.dp))

        Text(text = "Últ. actualización: $lastUpdate")

        Spacer(GlanceModifier.height(8.dp))

        Button(
            text = "Ver panel",
            onClick = actionStartActivity<MainActivity>()
        )
    }
}
