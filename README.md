# intellij-antimony

![Build](https://github.com/dweindl/intellij-antimony/workflows/Build/badge.svg)

<!-- Plugin description -->
This IntelliJ Platform plugin provides basic support for the
[Antimony](https://doi.org/10.1093/bioinformatics/btp401)
[language](https://tellurium.readthedocs.io/en/latest/antimony.html).

Files with the `.ant` extension will be recognized as Antimony files.

**Features**:

* Syntax highlighting
* Rename refactoring
* Find usages
* Go to declaration
* Conversion between SBML and Antimony
* structure view
* (very basic) code completion
<!-- Plugin description end -->


*Development is in a very early stage, so expect bugs and missing features.
Code quality is also not great yet. This is my first IntelliJ plugin, so I'm still learning.
Grammar is still incomplete, so some Antimony files may not be parsed correctly.
Everything is subject to change. Contributions are welcome.*


## Installation

Download the [latest release](https://github.com/dweindl/intellij-antimony/releases/latest) and install it manually using
<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template] which was released under the
[Apache-2.0 license](https://github.com/JetBrains/intellij-platform-plugin-template/blob/81206eb0c2c9af1336750a13e471155b4fd2bea8/LICENSE).

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
