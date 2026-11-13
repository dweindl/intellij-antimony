# Releasing

The plugin is distributed via GitHub releases only (not JetBrains Marketplace).

1. Bump `pluginVersion` in `gradle.properties` (SemVer)
   and make sure the `## [Unreleased]` section of `CHANGELOG.md` is complete.
   Merge this into `main`.
   This is the only manual version bump; `plugin.xml` gets version, description and change notes at build time.
2. Wait for the *Build* workflow on `main` to pass.
   Its last job (*Release draft*) deletes old drafts
   and creates a draft release `v<pluginVersion>`
   with the `[Unreleased]` changelog section as release notes.
   The draft is only created if all jobs, including plugin verification, succeed.
3. On GitHub, review the draft release, edit the notes if needed, and publish it.
   Publishing creates the tag `v<pluginVersion>` on `main`.
4. Publishing triggers the *Release* workflow, which
   * moves the `[Unreleased]` changelog entries under a new `[<pluginVersion>]` heading,
   * builds the plugin zip and attaches it to the release,
   * opens a pull request "Changelog update - `v<pluginVersion>`" with the patched `CHANGELOG.md`.
5. Merge that changelog pull request.

If `pluginVersion` is not bumped, the draft gets the tag of an already published release.
