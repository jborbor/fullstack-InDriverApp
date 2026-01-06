import { StyleSheet, Image, TextInput, View, KeyboardType } from "react-native";

interface Props {
    placeholder: string;
    value: string;
    onChangeText: (text: string) => void;
    keyboardType?: KeyboardType;
    icon: any;
    secureTextEntry?: boolean;
}

const DefaultTextInput = ({ placeholder, value, onChangeText, keyboardType, icon, secureTextEntry }: Props) => {
    return (
        <View style={styles.containerTextInput}>
            <Image
                style={styles.textInputIcon}
                source={icon}
            ></Image>
            <TextInput
                style={styles.textInput}
                placeholder={placeholder}
                placeholderTextColor="white"
                onChangeText={text => onChangeText(text)}
                keyboardType={keyboardType || "default"}
                value={value}
                secureTextEntry={secureTextEntry || false}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    containerTextInput: {
        flexDirection: "row",
        alignItems: "center",
        marginTop: 10,
    },
    textInputIcon: {
        width: 25,
        height: 25,
        marginRight: 15,
    },
    textInput: {
        width: "90%",
        height: 50,
        borderBottomWidth: 1,
        borderBottomColor: "white",
        color: "white",
        fontSize: 18,
    },
});

export default DefaultTextInput;
