<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# intellij-antimony Changelog

## [Unreleased]

### Added

- Extended annotation grammar to support many more standard biological annotation keywords (`hasPart`, `isPartOf`, `isVersionOf`, `isHomologTo`, `isDescribedBy`, `isEncodedBy`, `occursIn`, `hasProperty`, `hasTaxon`, `creator.*` fields, and more)

### Fixed

- Fixed a parsing bug where an Antimony file whose last statement has no trailing newline failed to parse entirely, losing syntax highlighting, references, and rename support for the whole file

### Changed

- Removed the plugin's upper IDE-version compatibility bound, so it keeps working with newer IntelliJ Platform releases without requiring a new plugin release
- Renamed the plugin id from `intellij-antimony` to `antimony-language` (JetBrains Marketplace naming requirement)

## [0.0.2] - 2024-06-16

- Tool window for SBML -> Antimony conversion
- Option to convert Antimony model to SBML
- Additional tokens for syntax highlighting
- Additional entries for color settings
- Independent color settings for different types of identifiers
- Nicer file type icon
- Extended grammar for Antimony

## [0.0.1] - 2024-06-03

### Added

- Syntax highlighting with basic color settings
- Rename refactoring
- Find usages
- Go to declaration
- (very basic) code completion
- (very basic) structure view
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

[Unreleased]: https://github.com/dweindl/intellij-antimony/compare/v0.0.2...HEAD
[0.0.2]: https://github.com/dweindl/intellij-antimony/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/dweindl/intellij-antimony/commits/v0.0.1
