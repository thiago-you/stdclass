# Stdclass
Standard object, adapter and collections for generic uses.

### Standard Class
    - IStdObject
    - StdAdapter
    - StdCollections
    - StdObject
    - enums
        - BaseStdCollections

### Requirements
    Min SDK Version >= 19

### Extending collections
StdCollections and BaseCollection can be easily extended do add new lists. List values can be set on collections.xml (or any other xml resource file), can also use specific translations to get a dynamic list.

Collections can use tree array types:

    - Integer keys => collections keys (if not set, use default iteration count)
    - String values => collections values (required)
    - String extras => collection extra value (can be used for multiple purposes inside StdAdapter)

Collections arrays must have the exact same size, otherwise it will be iterate over the smallest. Into collections.xml arrays is commonly defined as "name"_keys, "name"_values and "name"_extras.

### Custom StdObject
Is possible to create your own StdObject implementing IStdObject contract.

### Import library from Jitpack
    - Add Jitpack repository into you project (build.gradle):

        allprojects {
            repositories {
                ...
                maven { url 'https://jitpack.io' }
            }
        }

    - Add library implementation into build.gradle (Module:app)

        dependencies {
            ...
            implementation 'com.github.thiago-you:stdclass:Tag'
        }

    - Sync build.gradle and build your project

See [Jitpack](https://jitpack.io/docs/) docs for more info.

### Download Library
Follow these steps to import the library into your project:

    - Download the library
    - Go to you project under "File" -> "New" -> "Import Module"
    - In build.gradle, import library as "implementation project(':stdclass')"
    - Sync build.gradle and build your project