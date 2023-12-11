import Foundation
import SwiftUI
import Views

struct CustomToolBar: View {
  let isArchived: Bool
  let archiveAction: () -> Void
  let unarchiveAction: () -> Void
  let shareAction: () -> Void
  let deleteAction: () -> Void

  var barColor: Color {
    switch ThemeManager.currentTheme {
    case .apollo:
      return Color.themeMiddleGray
    case .dark:
      return Color.themeMiddleGray
    case .light:
      return Color.themeDarkWhiteGray
    case .sepia:
      return Color.themeDarkWhiteGray
    case .system:
      return Color.isDarkMode ? Color.themeMiddleGray : Color.themeDarkWhiteGray
    }
  }

  var body: some View {
    VStack {
      barColor
        .frame(height: 0.5)
        .frame(maxWidth: .infinity)
      HStack(spacing: 0) {
        if isArchived {
          ToolBarButton(image: Image.toolbarUnarchive, action: unarchiveAction)
        } else {
          ToolBarButton(image: Image.toolbarArchive, action: archiveAction)
        }
        ToolBarButton(image: Image.toolbarShare, action: shareAction)
        ToolBarButton(image: Image.toolbarTrash, action: deleteAction)
      }
      .padding(.top, 8)
    }
    .padding(.bottom, 30)
    .background(ThemeManager.currentBgColor)
  }
}

struct ToolBarButton: View {
  let image: Image
  let action: () -> Void

  var body: some View {
    Button(action: {
      action()
    }, label: {
      image
        .resizable()
        .renderingMode(.template)
        .aspectRatio(contentMode: .fit)
        .frame(width: 28, height: 28)
        .foregroundColor(ThemeManager.currentTheme.toolbarColor)
        .frame(maxWidth: .infinity)
    })
  }
}
