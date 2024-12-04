# SRC Folder

This README exists, so the folder shows up in source control like git. This
file is not needed and can be safely deleted.

However, for completeness, this folder exists for the purpose of storing your
source code. As a reminder, by discipline, this folder must contain at least
four Java files:

1. The Kernel Interface (e.g., `CarFuelMonitorKernel`)
2. The Enhance Interface (e.g., `CarFuelMonitor`)
3. The Secondary Abstract Class (e.g., `CarFuelMonitorSecondary`)
4. A Kernel Implementation (e.g., `CarFuelMonitor1L`)

Ideally, you will want to package your component appropriately as well.
That means not just dumping your source code in the `src` folder but actually
creating nested folders for grouping similar components. For example, the
`CarFuelMonitor` API can be found in the `src/components/CarFuelMonitor` package.
In other words, you would need to nest a `components` folder in the `src`
folder. Then, nest the `CarFuelMonitor` folder in the `components` folder.
The result would be the following directory structure:

```
src
└───components
    └───CarFuelMonitor
            CarFuelMonitor.java
            CarFuelMonitor1L.java
            CarFuelMonitorKernel.java
            CarFuelMonitorSecondary.java
```

If done correctly, your portfolio can be bundled as its own `.jar`.
