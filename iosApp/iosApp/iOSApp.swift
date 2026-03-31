import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        KoinBridgeKt.initializeKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
