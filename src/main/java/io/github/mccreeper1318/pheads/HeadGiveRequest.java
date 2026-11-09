package io.github.mccreeper1318.pheads;

import java.util.Arrays;
import java.util.Locale;

record HeadGiveRequest(
        Status status,
        Kind kind,
        HeadType headType,
        String requestedKey) {

    enum Status {
        VALID,
        MISSING_HEAD,
        UNKNOWN_HEAD
    }

    enum Kind {
        NORMAL,
        TROPHY
    }

    static HeadGiveRequest parse(String[] args) {
        Kind kind = args.length >= 2 && args[1].equalsIgnoreCase("trophy")
                ? Kind.TROPHY
                : Kind.NORMAL;
        int headStartIndex = kind == Kind.TROPHY ? 2 : 1;

        if (args.length <= headStartIndex) {
            return new HeadGiveRequest(Status.MISSING_HEAD, kind, null, "");
        }

        String requestedKey = String.join(
                        "-",
                        Arrays.copyOfRange(args, headStartIndex, args.length))
                .toLowerCase(Locale.ROOT)
                .replace('_', '-');

        HeadType headType = Arrays.stream(HeadType.values())
                .filter(type -> type.configKey().equals(requestedKey))
                .findFirst()
                .orElse(null);

        if (headType == null) {
            return new HeadGiveRequest(
                    Status.UNKNOWN_HEAD,
                    kind,
                    null,
                    requestedKey);
        }

        return new HeadGiveRequest(
                Status.VALID,
                kind,
                headType,
                requestedKey);
    }

    boolean trophy() {
        return kind == Kind.TROPHY;
    }
}
